package br.thullyo.todolist.controller;

import br.thullyo.todolist.model.ToolRequest;
import br.thullyo.todolist.model.ToolResponse;
import br.thullyo.todolist.service.ToolService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<ToolResponse>> getAllTools(){
        return ResponseEntity.status(HttpStatus.OK).body(toolService.getAllTools());
    }

    @GetMapping("/byTag")
    public ResponseEntity<List<ToolResponse>> getAllByTag(@RequestParam String tag){
        return ResponseEntity.status(HttpStatus.OK).body(toolService.getAllByTag(tag));
    }


}
