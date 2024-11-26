package io.chris.rxinitclient.readdata.export.web;

import io.chris.rxinitclient.readdata.service.ReadDataSync;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class ClientController {

    private final ReadDataSync readDataSync;

    @GetMapping("/sync")
    public Mono<ResponseEntity> sync() {
        return readDataSync.getSingleRecord()
                .map(record -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("data", record);
                    map.put("timestamp", System.currentTimeMillis());
                    return map;
                })
                .map(ResponseEntity::ok);
    }
}
