package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

<<<<<<< HEAD
    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;
=======
    private Map<String, String> env = new HashMap<>();

    public EnvController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${MEMORY_LIMIT:NOT SET}") String memLimit,
            @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
            @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {

        this.env.put("PORT", port);
        this.env.put("MEMORY_LIMIT", memLimit);
        this.env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        this.env.put("CF_INSTANCE_ADDR", cfInstanceAddr);
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
<<<<<<< HEAD
        Map<String, String> env = new HashMap<>();
        env.put("PORT",this.port);
        env.put("MEMORY_LIMIT",this.memoryLimit);
        env.put("CF_INSTANCE_INDEX",this.cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR",this.cfInstanceAddr);
=======
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
        return env;
    }
}
