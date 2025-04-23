package za.co.cascade.controller;

import org.springframework.web.bind.annotation.*;
import za.co.cascade.model.ValidationRequest;
import za.co.cascade.model.ValidationResponse;
import za.co.cascade.ValidateSaIdWeb;

@RestController
@RequestMapping("/api/validate")
public class ValidationController {
    @PostMapping
    public ValidationResponse validateId(@RequestBody ValidationRequest request) {
        boolean valid = ValidateSaIdWeb.isIdNumberValid(request.getIdNumber());
        return new ValidationResponse(valid);
    }
}
