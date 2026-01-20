package stack;

import java.util.Arrays;
import java.util.Stack;

public class SimplifiedPath {

    public static String simplifyPath(String path) {

        StringBuilder simplifiedPath = new StringBuilder();
        String[] folders = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String item : folders){

            if(item.equals(".") || item.isEmpty()) continue;

            else if (item.equals(".."))
                if (!stack.isEmpty()) stack.pop();

            else stack.push(item);

        }

        for(String item : stack){
            simplifiedPath.append("/").append(item);
        }

        if(simplifiedPath.isEmpty()) return "/";
        return simplifiedPath.toString();

    }
    public static void main(String[] args) {

        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));

    }
}
