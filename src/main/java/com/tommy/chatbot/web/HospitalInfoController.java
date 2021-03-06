package com.tommy.chatbot.web;

import com.tommy.chatbot.domain.HospitalInfo;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RequestMapping("/hospitalinfoes")
@Controller
@RooWebScaffold(path = "hospitalinfoes", formBackingObject = HospitalInfo.class)
public class HospitalInfoController {

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, hospitalInfo);
            return "hospitalinfoes/create";
        }
        uiModel.asMap().clear();
        hospitalInfo.persist();
        return "redirect:/hospitalinfoes/" + encodeUrlPathSegment(hospitalInfo.getId().toString(), httpServletRequest);
    }

    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new HospitalInfo());
        return "hospitalinfoes/create";
    }

    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("hospitalinfo", HospitalInfo.findHospitalInfo(id));
        uiModel.addAttribute("itemId", id);
        return "hospitalinfoes/show";
    }

    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("hospitalinfoes", HospitalInfo.findHospitalInfoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) HospitalInfo.countHospitalInfoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("hospitalinfoes", HospitalInfo.findAllHospitalInfoes(sortFieldName, sortOrder));
        }
        return "hospitalinfoes/list";
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, hospitalInfo);
            return "hospitalinfoes/update";
        }
        uiModel.asMap().clear();
        hospitalInfo.merge();
        return "redirect:/hospitalinfoes/" + encodeUrlPathSegment(hospitalInfo.getId().toString(), httpServletRequest);
    }

    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, HospitalInfo.findHospitalInfo(id));
        return "hospitalinfoes/update";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        HospitalInfo hospitalInfo = HospitalInfo.findHospitalInfo(id);
        hospitalInfo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/hospitalinfoes";
    }

    void populateEditForm(Model uiModel, HospitalInfo hospitalInfo) {
        uiModel.addAttribute("hospitalInfo", hospitalInfo);
    }

    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
