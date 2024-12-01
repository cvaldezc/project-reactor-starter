package io.chris.rxinitclient.readdata.export.web;

import io.chris.rxinitclient.readdata.model.DataRecord;
import io.chris.rxinitclient.readdata.service.ReadDataAsync;
import io.chris.rxinitclient.readdata.service.ReadDataSync;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class ClientController {

    private final ReadDataSync readDataSync;
    private final ReadDataAsync readDataAsync;

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

    @GetMapping(value = "/async/streaming", produces = APPLICATION_STREAM_JSON_VALUE)
    public Flux<DataRecord> asyncStreaming() {
        return readDataAsync.getEachRecord();
    }

    @GetMapping("/async")
    public Mono<List<DataRecord>> asyncAllData() {
        return readDataAsync.getAllRecords();
    }
}
