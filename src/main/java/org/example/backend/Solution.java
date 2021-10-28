package org.example.backend;

public class Solution {
    private String namePart;
    private String expressionPart;

    public Solution(String namePart, String expressionPart) {
        this.namePart = namePart;
        this.expressionPart = expressionPart;
    }

    public String getNamePart() {
        return namePart;
    }

    public String getExpressionPart() {
        return expressionPart;
    }

    @Override
    public String toString() {
        return namePart + " " + expressionPart;
    }
}
