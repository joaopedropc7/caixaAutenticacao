package br.com.caixa.domain.user;

import br.com.caixa.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
