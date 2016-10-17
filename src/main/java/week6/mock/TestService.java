package week6.mock;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;
/**
 * Created by serhii on 10/16/16.
 */
public class TestService {

    private Service service;
    private Dao dao;
    private RemoteApi remoteApi;

    @Before
    public void before(){
        dao = mock(Dao.class);

        when(dao.find("B")).thenReturn(Arrays.asList("Bogdan","Bodia","Bod"));
        when(dao.find(anyString())).thenReturn(Arrays.asList("Bogdan","Bodia","Bod","asdfa", "asdfxcv",""));

        remoteApi = mock(RemoteApi.class);
        when(remoteApi.getNames())


        service = new Service()
    }

    @Test
    public void testService(){



    }


}
