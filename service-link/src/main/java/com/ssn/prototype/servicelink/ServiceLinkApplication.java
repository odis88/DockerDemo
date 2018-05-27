package com.ssn.prototype.servicelink;

import com.ssn.prototype.servicelink.entity.Link;
import com.ssn.prototype.servicelink.repo.LinkRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.ws.rs.PathParam;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceLinkApplication {

    @Autowired
    LinkRepo linkRepo;

    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(ServiceLinkApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceLinkApplication.class).run(args);
    }

    @GetMapping("/ping/pong")
    public String ping() {
        return "pong";
    }

    @PostMapping("/short")
    public String getShort(@RequestBody String link) {
        Link longLink = linkRepo.findByLongLink(link);
        if (longLink == null) {
            Link newLink = new Link();
            newLink.setLongLink(link);
            newLink.setShortLink(Long.toString(System.currentTimeMillis()));

            linkRepo.save(newLink);
            return "http://localhost:" + environment.getProperty("local.server.port") + "/"+ newLink.getShortLink();
        }
        return "http://localhost:" + environment.getProperty("local.server.port") + "/"+ longLink.getShortLink();

    }

    @GetMapping("/{url}")
    public RedirectView redirect(@PathVariable("url") String url) {
        logger.info("URL = " + url);
        Link link = linkRepo.findByShortLink(url);
        if (link != null) {
            return new RedirectView(link.getLongLink());
        }

        return new RedirectView("http://google.com");
    }
}
