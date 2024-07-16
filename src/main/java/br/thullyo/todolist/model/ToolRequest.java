package br.thullyo.todolist.model;

import java.util.Set;

public record ToolRequest(String title, String link, String description, Set<String> tags) {
}
