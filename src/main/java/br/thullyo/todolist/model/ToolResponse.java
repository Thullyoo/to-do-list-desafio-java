package br.thullyo.todolist.model;

import java.util.Set;

public record ToolResponse(String title, String link, String description, Set<String> tags, Integer id) {
}
