package com.crunchydata.completions;

import java.util.Arrays;
import java.util.Iterator;

public class MajorVersionCompletion implements Iterable{
    @Override
    public Iterator <String> iterator() {
        return Arrays.asList("bctl", "major-version-completions").iterator();
    }
}
