package studyart.utils.dymanic.core;

/**
 * Created by serhii on 04.09.16.
 */
public interface ExecutionCore {


    String compile(String path);

    String execute(String compiledPath) throws ExecutionCommandException;
}
