package com.demo.springwebfluxdemo.config.converter;

import com.demo.springwebfluxdemo.model.metadata.CourseMetadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

@ReadingConverter
@Slf4j
public class JsonToCourseMetadataConverter implements Converter<Json, CourseMetadata> {

    private final ObjectMapper mapper;

    public JsonToCourseMetadataConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CourseMetadata convert(Json source) {
        try {
            return mapper.readValue(source.asString(), CourseMetadata.class);
        } catch (IOException e) {
            log.error("Error while converting JSON to CourseMetaData", e);
            throw new RuntimeException(e);
        }
    }
}
