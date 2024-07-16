package br.thullyo.todolist.service;

import br.thullyo.todolist.model.Tool;
import br.thullyo.todolist.model.ToolRequest;
import br.thullyo.todolist.model.ToolResponse;
import br.thullyo.todolist.repository.ToolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public ToolResponse registerTool(ToolRequest toolRequest){
        Tool tool = new Tool();

        BeanUtils.copyProperties(toolRequest, tool);
        toolRepository.save(tool);


        return new ToolResponse(tool.getTitle(),tool.getLink(),tool.getDescription(),tool.getTags(),tool.getId());
    }

    public List<ToolResponse> getAllTools(){
        List<ToolResponse> tools = toolRepository.findAll().stream().map(tool -> {
            return new ToolResponse(tool.getTitle(), tool.getLink(), tool.getDescription(), tool.getTags(), tool.getId());
        }).toList();
        return tools;
    }

}
