package com.abstractfactory.example.domain.ui;

import java.util.List;

public interface Table {
    String render(List<?> data);
}
