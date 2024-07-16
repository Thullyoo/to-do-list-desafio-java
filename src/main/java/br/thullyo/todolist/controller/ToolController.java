package br.thullyo.todolist.controller;

import br.thullyo.todolist.model.ToolRequest;
import br.thullyo.todolist.model.ToolResponse;
import br.thullyo.todolist.service.ToolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping()
    public ResponseEntity<ToolResponse> registerTool(@RequestBody ToolRequest toolRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(toolService.registerTool(toolRequest));
    }
}
