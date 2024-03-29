package com.cakmak.todov2.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    private List<T> items = List.of();
    private Integer numberOfItems ;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("listItems: ");
        if (items != null) {
            items.forEach(item -> {
                sb.append(item.toString());
                sb.append('\n');
            });
        }
        return sb.toString();
    }

}
