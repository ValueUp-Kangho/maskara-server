package com.server.maskara.controller.qr;

import com.server.maskara.domain.qr.request.RequestQr;
import com.server.maskara.domain.qr.response.ResponseQr;
import com.server.maskara.entity.User;
import com.server.maskara.service.qr.QrService;
import com.server.maskara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QrControoler {

    private final UserService userService;
    private final QrService qrService;
    @PostMapping("/mask")
    public ResponseEntity<ResponseQr> scanQr(@RequestBody RequestQr requestQr) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ResponseQr result = qrService.scanQr(username, requestQr);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
