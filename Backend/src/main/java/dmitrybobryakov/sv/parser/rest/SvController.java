package dmitrybobryakov.sv.parser.rest;

import dmitrybobryakov.sv.parser.service.SvParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class SvController {

    private SvParserService service;

    @Autowired
    public SvController(SvParserService service) {
        this.service = service;
    }

    @RequestMapping("/parse-message")
    public ResponseEntity<Map<String, String>> getMessageFields(@RequestParam String message) throws Exception {
        Map<String, String> fields = service.getMessageFields(message);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

}