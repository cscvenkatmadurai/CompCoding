package lc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {

        Map<String, boolean[]> cityToIncomingEdgeAndOutGoingEdge = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            final List<String> path = paths.get(i);
            final String source = path.get(0);
            final String dest = path.get(1);

        }

        return "";
    }
}


