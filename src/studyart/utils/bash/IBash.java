package studyart.utils.bash;

import studyart.utils.dymanic.core.ExecutionCommandException;

/**
 * Created by serhii on 04.09.16.
 */
public interface IBash {

    String executeCommand(String command, String...args)
            throws ExecutionCommandException;
}
