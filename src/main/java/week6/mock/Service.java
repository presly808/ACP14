package week6.mock;

import java.util.List;

/**
 * Created by serhii on 10/16/16.
 */
class Service {

    private Dao dao;
    private RemoteApi remoteApi;

    public Service(Dao dao, RemoteApi remoteApi) {
        this.dao = dao;
        this.remoteApi = remoteApi;
    }

    public List<String> search(String key, boolean sortAsc) {
        // preprocess key
        List<String> namesLocal = dao.find(key);
        List<String> namesRemote = remoteApi.getNames(key);

        namesRemote.stream().forEach(namesLocal::add);

        namesLocal.sort(String::compareTo);

        return namesLocal;
    }


}
