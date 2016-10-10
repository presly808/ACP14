package studyart.utils.bash;

import com.sun.deploy.util.StringUtils;
import studyart.utils.IOUtils;
import studyart.utils.dymanic.core.ExecutionCommandException;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by serhii on 04.09.16.
 */
public class BashImpl implements IBash {
    @Override
    public String executeCommand(String command, String...args) throws ExecutionCommandException {

        String formattedArgs = String.join(" ", args);

        String formattedCommand = String.format("%s %s", command, formattedArgs);

        try {

            Process process = Runtime.getRuntime().exec(formattedCommand);
            process.waitFor();

            int resultCode = process.exitValue();

            String result = IOUtils.readAll(process.getInputStream());
            String error = IOUtils.readAll(process.getErrorStream());

            if(resultCode != 0 || !error.isEmpty()){
                throw new ExecutionCommandException(error);
            }

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "";
    }





}
