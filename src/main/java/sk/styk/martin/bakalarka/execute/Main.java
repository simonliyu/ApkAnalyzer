package sk.styk.martin.bakalarka.execute;

import sk.styk.martin.bakalarka.execute.arguments.Arguments;
import sk.styk.martin.bakalarka.execute.arguments.ArgumentsFactory;
import sk.styk.martin.bakalarka.execute.arguments.TaskMode;
import sk.styk.martin.bakalarka.execute.tasks.AnalyzeTask;
import sk.styk.martin.bakalarka.execute.tasks.CompareTask;
import sk.styk.martin.bakalarka.execute.tasks.StatisticsTask;
import sk.styk.martin.bakalarka.execute.tasks.Task;

/**
 * Created by Martin Styk on 23.11.2015.
 */
public class Main {

    //java -jar ApkAnalyzer.jar  -analyze -in=d:/jar/in -out=d:/jar/out_json
    //java -jar ApkAnalyzer.jar  -compare -in=d:/jar/out_json -out=d:/jar/out_compare
    //java -jar ApkAnalyzer.jar  -statistics -in=d:/jar/out_json -out=d:/jar/out_statistics
    public static void main(String[] args) throws Exception {

        Arguments commandLineArgs = new ArgumentsFactory(args).parseArguments();

        String inputDirectory = commandLineArgs.getInputDirectory();
        String outputDirectory = commandLineArgs.getOutputDirectory();

        Task task = getCurrentTask(commandLineArgs.getTaskMode());

        task.setInputDirectory(inputDirectory)
                .setOutputDirectory(outputDirectory)
                .execute();


    }

    private static Task getCurrentTask(TaskMode taskMode) {
        switch (taskMode) {
            case ANALYZE:
                return new AnalyzeTask();
            case COMPARE:
                return new CompareTask();
            case STATISTICS:
                return new StatisticsTask();
        }
        throw new RuntimeException("No task specified");
    }

}

