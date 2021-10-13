package com.crunchydata.completions;

import java.util.Arrays;
import java.util.Iterator;

public class ProviderCompletion implements Iterable<String>{
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<String> iterator() {
        return Arrays.asList("bctl", "provider-completions").iterator();
    }
}
