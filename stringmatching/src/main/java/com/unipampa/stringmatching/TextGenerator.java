/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipampa.stringmatching;

import de.svenjacobs.loremipsum.LoremIpsum;

/**
 *
 * @author Auri Gabriel
 */
public class TextGenerator {
    private LoremIpsum loremIpsum;

    public TextGenerator(){
        this.loremIpsum = new LoremIpsum();
    }

    public String getByNumberOfWords(int words){
        return loremIpsum.getWords(words);
    }

    public String getByNumberOfParagraphs(int paragraphs){
        return loremIpsum.getParagraphs(paragraphs);
    }
}


