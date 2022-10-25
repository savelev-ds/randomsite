package ru.badegva.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.badegva.app.usecase.ApproveHref;
import ru.badegva.app.usecase.GetAllUnapproved;
import ru.badegva.app.usecase.GetRandomSite;
import ru.badegva.app.usecase.PartnerHrefCount;
import ru.badegva.app.usecase.RemoveUnapproved;
import ru.badegva.app.usecase.SiteCount;
import ru.badegva.app.usecase.UnapprovedCount;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    private static final int ACT_APPROVE = 1;
    private static final int ACT_REMOVE = 0;

    private final GetAllUnapproved getAllUnapproved;
    private final RemoveUnapproved removeUnapproved;
    private final ApproveHref approveHref;
    private final UnapprovedCount unapprovedCount;
    private final SiteCount siteCount;
    private final PartnerHrefCount partnerHrefCount;

    public AdminController(
        GetAllUnapproved getAllUnapproved,
        RemoveUnapproved removeUnapproved,
        ApproveHref approveHref,
        UnapprovedCount unapprovedCount,
        SiteCount siteCount,
        PartnerHrefCount partnerHrefCount
    ) {
        this.getAllUnapproved = getAllUnapproved;
        this.removeUnapproved = removeUnapproved;
        this.approveHref = approveHref;
        this.unapprovedCount = unapprovedCount;
        this.siteCount = siteCount;
        this.partnerHrefCount = partnerHrefCount;
    }

    @GetMapping(value = {"/fd46914c-a322-49f0-8c88-ebf394f95df4"})
    public String index(Model model) {
        model.addAttribute("moderateCount", unapprovedCount.get());
        model.addAttribute("approvedCount", siteCount.getTotal());
        model.addAttribute("approvedRuCount", siteCount.getRu());
        model.addAttribute("partnerCount", partnerHrefCount.get());
        model.addAttribute("hrefs", getAllUnapproved.execute());
        return "admin";
    }

    @PostMapping("/act")
    public String act(
        @RequestParam("href") int moderatedHrefId,
        @RequestParam("ru") boolean isRu,
        @RequestParam("partner") boolean isPartner,
        @RequestParam("act") int act
    ) {
        switch (act) {
            case ACT_APPROVE:
                approveHref.execute(moderatedHrefId, isRu, isPartner);
                break;
            case ACT_REMOVE: removeUnapproved.execute(moderatedHrefId); break;
        }
        return "redirect:fd46914c-a322-49f0-8c88-ebf394f95df4";
    }

}
