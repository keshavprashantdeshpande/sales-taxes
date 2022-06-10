package com.codingchallenge.item.service;

import com.codingchallenge.item.Exemption;
import org.springframework.stereotype.Service;

/**
 * This behavior should be used on item which is exempted from the tax bracket
 */

@Service
public class ExemptedItem implements Exemption {

    @Override
    public boolean isExempted() {
        return true;
    }

}
