package test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.schronisko.domain.Toy;
import pl.schronisko.domain.cat;
import pl.schronisko.kontroler.ToyService;
import pl.schronisko.application.CatRepository;
import pl.schronisko.application.ToyRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ToyServiceTest {

	@Mock
	private ToyRepository toyDao;
	@Mock
	private CatRepository catDAO;

	@Mock
	private cat kot;

	@InjectMocks
	ToyService toyService;
	
	private static Toy toy1;
	
	
	
	/*@Before
	public void setUp() {
		toyService = new ToyService();
	} */
	
	@Test
	public void test_find_toy_by_cat(){

		toy1 = new Toy("piłka", 1 , "żółta piłeczka");
        when(toyDao.findByOwner(kot)).thenReturn(Arrays.asList(toy1));
        
        assertEquals(1, toyService.findAllToyByCat(kot).size());
	}
	
	@Test
	public void test_find_toy_by_id_toy() {
		int id =1;
		toy1 = new Toy("piłka", 1 , "żółta piłeczka");
		when(toyDao.findByIdToys(id)).thenReturn(toy1);
		assertEquals(toy1, toy1);
	}
	
}
