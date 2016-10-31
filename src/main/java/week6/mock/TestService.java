package week6.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        remoteApi = mock(RemoteApi.class);

        //when(dao.find("A")).thenReturn(Arrays.asList("Anton","Anatoliy"));
        List<String> list = new ArrayList<>();
        list.add("Anton");
        list.add("Anatoliy");

        when(dao.find(anyString())).thenReturn(list);

        when(remoteApi.getNames(anyString())).thenReturn(Arrays.asList("Andrey", "Alex"));

        service = new Service(dao,remoteApi);
    }

    @Test
    public void testService(){
        List<String> names = service.search("A", true);

        verify(dao).find(anyString());
        verify(remoteApi).getNames(anyString());

        Assert.assertEquals(4, names.size());
    }


}
