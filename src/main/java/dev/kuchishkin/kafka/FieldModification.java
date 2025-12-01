package dev.kuchishkin.kafka;

public record FieldModification<T>(
    T oldField,
    T newField
) {

}
