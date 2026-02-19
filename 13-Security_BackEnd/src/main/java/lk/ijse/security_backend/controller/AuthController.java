package lk.ijse.security_backend.controller;

import lk.ijse.security_backend.dto.APIResponse;
import lk.ijse.security_backend.dto.RegisterDTO;
import lk.ijse.security_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    public ResponseEntity<APIResponse> registerUser(@RequestBody RegisterDTO registerDTO){
        return  ResponseEntity.ok(new APIResponse(200,"OK",authService.register(registerDTO)));
    }
    @PostMapping("register")
    public ResponseEntity<APIResponse> logicUser(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(new APIResponse(200,"OK",authService.register(registerDTO)));
    }
}
