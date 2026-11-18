package partydj.backend.rest.entity.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static partydj.backend.rest.helper.JsonTestUtils.assertJsonEquals;

public class ArtistResponseTest {
    private final ArtistResponse artistResponse;
    private final ObjectMapper objectMapper;
    private final String path;

    private ArtistResponseTest() {
        artistResponse = ArtistResponse.builder()
                .name("artistName")
                .build();
        objectMapper = new ObjectMapper();
        path = "classpath:domain/response/artistResponse.json";
    }

    @Test
    @SneakyThrows
    void shouldSerialize() {
        final String actual = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(artistResponse);

        final File jsonFile = ResourceUtils.getFile(path);
        final String expected = Files.readString(jsonFile.toPath());

        assertJsonEquals(actual, expected);
    }

    @Test
    @SneakyThrows
    void shouldDeserialize() {
        final ArtistResponse actual = objectMapper.readValue(
                ResourceUtils.getFile(path), ArtistResponse.class);

        assertThat(actual).isEqualTo(artistResponse);
    }
}
