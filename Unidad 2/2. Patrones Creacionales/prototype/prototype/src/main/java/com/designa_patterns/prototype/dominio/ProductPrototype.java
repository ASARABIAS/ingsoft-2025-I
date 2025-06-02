package com.designa_patterns.prototype.dominio;

public interface ProductPrototype extends Cloneable {
    ProductPrototype clone();
    String getProductInfo();
}