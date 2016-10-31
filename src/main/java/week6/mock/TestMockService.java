package week6.mock;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMockService {


    private RemoteApi remoteApi;
    private Dao daoMock;

    @Before
    public void setUpData(){
        daoMock = mock(Dao.class);
        remoteApi = mock(RemoteApi.class);

        List<String> list = new ArrayList<>();
        list.add("Andrey");
        list.add("Anton");
        list.add("Alex");

        when(daoMock.find("A")).thenReturn(list);
        when(daoMock.find(isNull(String.class))).thenThrow(new NullPointerException());

        List<String> value = Arrays.asList("Anatoliy", "Anna", "Artem");
        when(remoteApi.getNames("A")).thenReturn(value);

    }

    @After
    public void tearDownMocks(){
        reset(remoteApi, daoMock);
    }

    @Test
    public void testSearch() {

        Service service = new Service(daoMock, remoteApi);

        List<String> names = service.search("A", true);

        Assert.assertNotNull(names);
        Assert.assertEquals(6, names.size());

    }

    @Test
    public void testSearchNegative() {

        Service service = new Service(daoMock, remoteApi);

        List<String> names = service.search("B", true);

        Assert.assertThat(names, is(isNull()));
        Assert.assertNotNull(names);
        Assert.assertEquals(1, is());


    }

}
