package dev.kuchishkin.model;

public record JwtUserPrincipal(
    String login,
    Long id
) {

}
