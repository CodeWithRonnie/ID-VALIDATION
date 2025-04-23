package za.co.cascade.controller;

import org.springframework.web.bind.annotation.*;
import za.co.cascade.model.ValidationRequest;
import za.co.cascade.model.ValidationResponse;
import za.co.cascade.ValidateSaIdWeb;

@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000", "http://localhost:8080", "http://127.0.0.1:53409"})
@RestController
@RequestMapping("/api/validate")
public class ValidationController {
    @PostMapping
    public ValidationResponse validateId(@RequestBody ValidationRequest request) {
        boolean valid = ValidateSaIdWeb.isIdNumberValid(request.getIdNumber());
        return new ValidationResponse(valid);
    }
}
