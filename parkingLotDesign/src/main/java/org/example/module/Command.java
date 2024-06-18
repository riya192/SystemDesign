package org.example.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Command {
    private String commandName;
    private List<String> params;

    @Override
    public String toString() {
        return "Command{" +
                "commandName='" + commandName + '\'' +
                ", params=" + params +
                '}';
    }
}
