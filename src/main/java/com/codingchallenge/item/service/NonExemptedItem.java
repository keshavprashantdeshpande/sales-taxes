package com.codingchallenge.item.service;

import com.codingchallenge.item.Exemption;
import org.springframework.stereotype.Service;

/**
 * This behavior should be used on item which is not exempted from the tax bracket
 */

@Service
public class NonExemptedItem implements Exemption {

    @Override
    public boolean isExempted() {
        return false;
    }

}
