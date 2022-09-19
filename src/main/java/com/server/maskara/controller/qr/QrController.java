package com.server.maskara.controller.qr;

import com.server.maskara.domain.qr.request.RequestQr;
import com.server.maskara.domain.qr.response.ResponseQr;
import com.server.maskara.service.qr.QrService;
import com.server.maskara.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public class QrController {
    private final QrService qrService;

    @ApiOperation(value = "QR 인식 - 회원 활동 내역에 저장", notes = "QR 인식시, 회원 활동 내역에 추가하며, 내역 정보를 반환한다.")
    @PostMapping("/mask")
    public ResponseEntity<ResponseQr> scanQr(@RequestBody RequestQr requestQr) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ResponseQr result = qrService.scanQr(username, requestQr);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
