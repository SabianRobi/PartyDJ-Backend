package partydj.backend.rest.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

public final class JsonTestUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonTestUtils() {
    }

    public static void assertJsonEquals(final String actual, final String expected) throws JsonProcessingException {
        assertThat(OBJECT_MAPPER.readTree(actual)).isEqualTo(OBJECT_MAPPER.readTree(expected));
    }
}
