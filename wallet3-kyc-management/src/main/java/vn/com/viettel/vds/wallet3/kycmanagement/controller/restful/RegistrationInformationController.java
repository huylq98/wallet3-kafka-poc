package vn.com.viettel.vds.wallet3.kycmanagement.controller.restful;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.request.RegistrationInformationRequestDto;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;
import vn.com.viettel.vds.wallet3.kycmanagement.service.RegistrationInformationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration-informations")
public class RegistrationInformationController {

    private final RegistrationInformationService registrationInformationService;

    @GetMapping
    public Page<RegistrationInformationResponseDto> findAll(Pageable pageable) {
        return registrationInformationService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegistrationInformationResponseDto save(@RequestBody RegistrationInformationRequestDto request) {
        return registrationInformationService.save(request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public RegistrationInformationResponseDto save(@PathVariable("id") Long id,
                                                   @RequestBody RegistrationInformationRequestDto request) {
        return registrationInformationService.save(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        registrationInformationService.delete(id);
    }
}
