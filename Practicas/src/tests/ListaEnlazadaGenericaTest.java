package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;



public class ListaEnlazadaGenericaTest {

		ListaEnlazadaGenerica<Integer> lista;
		
		@Before
		public void setUp() throws Exception {
			lista = new ListaEnlazadaGenerica<Integer>();
		}

		@Test
		public void testEsVacia() {
			assertTrue(lista.esVacia());
			
			lista.agregarFinal(2);
			
			assertFalse(lista.esVacia());
			
			lista.eliminar(2);
			
			assertTrue(lista.esVacia());
		}
		
		
		@Test
		public void testIncluye1() {
			
			lista.agregarFinal(3);
			
			assertFalse(lista.incluye(2));
			
			assertTrue(lista.incluye(3));
		}
		
		
		
		@Test
		public void testComenzar() {
			//Probando con un elemento
			lista.agregarFinal(0);
			lista.comenzar();
			assertEquals(new Integer(0), lista.elemento(1));
			
			//Probando con dos elementos
			lista.agregarFinal(1);
			lista.comenzar();
			assertEquals(new Integer(0), lista.elemento(1));
			
			//Probando de agregar un elemento al principio
			lista.agregarEn(2, 1);
			lista.comenzar();
			assertEquals(new Integer(2), lista.elemento(1));
			
			
		}

		@Test
		public void testProximo() {
			for (int i = 1; i <= 100; i++)
				lista.agregarEn(i, i);
			lista.comenzar();
			for (int i = 1; i <= 100; i++) {
				assertEquals(new Integer(i), lista.elemento(i));
				lista.proximo();
			}
			assertTrue(lista.fin());
				
		}

		@Test
		public void testElementoInt() {
			assertEquals(null, lista.elemento(0));
			for (int i = 1; i <= 100; i++)
				lista.agregarEn(i, i);
			for (int i = 100; i > 0; i--)
				assertEquals(new Integer(i), lista.elemento(i));
		}

		@Test
		public void testAgregarEnPosicion() {
			//No se puede agregar en indices negativos
			assertFalse(lista.agregarEn(1, -1));
			assertEquals(0, lista.tamanio());
			
			//Test de agregar al principio cuando no hay nada
			assertTrue(lista.agregarEn(2, 1));
			assertEquals(new Integer(2), lista.elemento(1));
			assertEquals(1, lista.tamanio());
			
			//Test de agregar al principio cuando hay algo
			assertTrue(lista.agregarEn(0, 1));
			assertEquals(new Integer(0), lista.elemento(1));
			assertEquals(new Integer(2), lista.elemento(2));		
			assertEquals(2, lista.tamanio());
			
			//Test de agregar entremedio
			assertTrue(lista.agregarEn(3, 2));
			assertEquals(new Integer(0), lista.elemento(1));
			assertEquals(new Integer(3), lista.elemento(2));		
			assertEquals(new Integer(2), lista.elemento(3));
			assertEquals(3, lista.tamanio());
			
			//Test de agregar al final
			assertTrue(lista.agregarEn(4, 4));
			assertEquals(new Integer(0), lista.elemento(1));
			assertEquals(new Integer(3), lista.elemento(2));
			assertEquals(new Integer(2), lista.elemento(3));
			assertEquals(new Integer(4), lista.elemento(4));
			assertEquals(4, lista.tamanio());
			
			//Test de agregar despues del final
			assertFalse(lista.agregarEn(4, 6));
			assertEquals(new Integer(0), lista.elemento(1));
			assertEquals(new Integer(3), lista.elemento(2));
			assertEquals(new Integer(2), lista.elemento(3));
			assertEquals(new Integer(4), lista.elemento(4));
			assertEquals(4, lista.tamanio());
			
		}
		
		@Test 
		public void testAgregar(){
			// Test de agregar al principio cuando no hay nada
			lista.agregarInicio(new Integer(0));
			assertEquals(1,lista.tamanio());// [0]
				
			// Test de agregar al principio cuando hay algo
			lista.comenzar();
			lista.agregarInicio(1);//[1,0]
			lista.comenzar();
			assertEquals(new Integer(1),lista.proximo());
			assertEquals(2,lista.tamanio());
			assertEquals(new Integer(0),lista.proximo());
			
			
			
			// Test de agregar entremedio
			lista.agregarEn(3,2);//[1,3,0]
			assertEquals(3,lista.tamanio());
			lista.comenzar();
			lista.proximo();
			assertEquals(new Integer(3),lista.proximo());
			// Test de agregar al final
			
			lista.agregarFinal(10);//[1,3,0,10]
			assertEquals(4,lista.tamanio());
			assertEquals(new Integer(10),lista.elemento(4));
		}
		
		@Test
		public void testEliminar() {
			//No se puede eliminar si no hay nada
			assertFalse(lista.eliminarEn(0));
			assertEquals(0, lista.tamanio());
			
			//Test eliminar el unico elemento que hay
			lista.agregarFinal(0);
			lista.comenzar();
			assertTrue(lista.eliminar(0));
			assertEquals(0, lista.tamanio());
			
			for (int i = 1; i <= 10; i++)
				lista.agregarEn(i, i);
			// lista =[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
			//Test eliminar el primer elemento cuando hay mas
			lista.comenzar();
			assertTrue(lista.eliminar(1));
			assertEquals(9, lista.tamanio());
			// lista =[2, 3, 4, 5, 6, 7, 8, 9, 10]
			for (int i = 1; i <= lista.tamanio(); i++)
				assertEquals(new Integer(i + 1), lista.elemento(i));
			
			//Test eliminar un elemento del medio
			lista.comenzar();
			lista.proximo();
			assertTrue(lista.eliminar(3));
			assertEquals(8, lista.tamanio());
			// lista =[ 2, 4, 5, 6, 7, 8, 9, 10]
			assertEquals(new Integer(2), lista.elemento(1));
			assertEquals(new Integer(4), lista.elemento(2));
			assertEquals(new Integer(10), lista.elemento(8));
			
			//Test eliminar el ultimo elemento
			lista.comenzar();
			for (int i = 0; i < 8; i++)
				lista.proximo();
			// lista =[ 2, 4, 5, 6, 7, 8, 9, 10]
			assertTrue(lista.eliminar(10));
			assertEquals(7, lista.tamanio());
			
			// lista =[ 2, 4, 5, 6, 7, 8, 9]
			assertEquals(new Integer(2), lista.elemento(1));
			assertEquals(new Integer(4), lista.elemento(2));
			assertEquals(new Integer(9), lista.elemento(7));
			assertEquals(null, lista.elemento(8));
			
			//Test de eliminar luego de haber recorrido todo.
			lista.comenzar();
			while (!lista.fin())
				lista.proximo();
			assertFalse(lista.eliminar(10));
			assertEquals(7, lista.tamanio());
			
			// lista =[ 2, 4, 5, 6, 7, 8, 9]
					assertEquals(new Integer(2), lista.elemento(1));
					assertEquals(new Integer(4), lista.elemento(2));
					assertEquals(new Integer(9), lista.elemento(7));
					assertEquals(null, lista.elemento(8));
			
			
			
		}

		@Test
		public void testEliminarEn() {
			//No se puede borrar indices negativos
			assertFalse(lista.eliminarEn(-1));
			assertEquals(0, lista.tamanio());
			
			//Test eliminar el unico elemento que hay
			lista.agregarEn(0, 1);
			assertTrue(lista.eliminarEn(1));
			assertEquals(0, lista.tamanio());
			
			for (int i = 1; i <= 10; i++)
				lista.agregarEn(i, i);

			//Test eliminar el primer elemento cuando hay mas
			assertTrue(lista.eliminar(1));
			assertEquals(9, lista.tamanio());
			for (int i = 1; i <= lista.tamanio(); i++)
				assertEquals(new Integer(i + 1), lista.elemento(i));
			
			//Test eliminar un elemento del medio
			lista.agregarEn(1, 1);
			assertTrue(lista.eliminarEn(1));
			assertEquals(9, lista.tamanio());
			for (int i = 1; i <= lista.tamanio(); i++)
				assertEquals(new Integer(i + 1), lista.elemento(i));
			
			//Test eliminar el ultimo elemento
			assertTrue(lista.eliminarEn(lista.tamanio()));
			assertEquals(8, lista.tamanio());
			for (int i = 1; i <= lista.tamanio(); i++) {
				assertEquals(new Integer(i + 1), lista.elemento(i));
			}
			//No se puede eliminar un indice >= tamaño.
			assertFalse(lista.eliminarEn(9));
			assertEquals(8, lista.tamanio());
			for (int i = 1; i <= lista.tamanio(); i++)
				assertEquals(new Integer(i + 1), lista.elemento(i));
			
			int tamanio = lista.tamanio();
			for (int i = 1; i <= tamanio; i++) {
				assertTrue(lista.eliminarEn(lista.tamanio()));
				
			}
			
			assertEquals(0, lista.tamanio());
			assertTrue(lista.esVacia());
			
		}

		@Test
		public void testIncluye() {
			//No se tiene que poder encontrar algo cuando la lista esta vacia
			assertFalse(lista.incluye(0));
			
			//Test de busqueda sobre el primer elemento
			lista.agregarFinal(0);
			assertTrue(lista.incluye(0));
			assertFalse(lista.incluye(1));
			
			//Test con mas elementos
			lista.agregarEn(1, 1);
			lista.agregarEn(2, 2);
			assertTrue(lista.incluye(1));
			assertFalse(lista.incluye(4));
			
		}

		@Test
		public void testFin() {
			lista.comenzar();
			assertTrue(lista.fin());
			
			lista.agregarFinal(0);
			lista.comenzar();
			assertFalse(lista.fin());
			lista.proximo();
			assertTrue(lista.fin());
			
			lista.agregarEn(1, 1);
			lista.comenzar();
			assertFalse(lista.fin());
			lista.proximo();
			assertFalse(lista.fin());
			lista.proximo();
			assertTrue(lista.fin());

		}
		
		
		@Test
		public void testVaciarLista() {
			lista.comenzar();
			lista.agregarFinal(22);
			lista.agregarFinal(33);
			lista.agregarFinal(44);
			lista.agregarFinal(55);
			lista.agregarFinal(66);
			lista.agregarFinal(77);
			
			assertFalse(lista.esVacia());
			
			lista.comenzar();
			while (!lista.fin()) {
				lista.eliminar(lista.proximo());
			}
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			
			
			lista.agregarFinal(222);
			lista.agregarFinal(333);
			lista.agregarFinal(444);
			lista.agregarFinal(555);
			lista.agregarFinal(566);
			lista.agregarFinal(777);
			
			assertEquals(6,lista.tamanio());
			
			assertEquals(new Integer(222),lista.elemento(1));
			assertEquals(new Integer(777),lista.elemento(6));
			
			
			
			
			int tamanio = lista.tamanio();
			for (int i=1; i<= tamanio; i++)
				assertTrue(lista.eliminarEn(lista.tamanio()));
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			lista.agregarFinal(1);
			assertFalse(lista.esVacia());
			
			assertEquals(1,lista.tamanio());
			
			lista.agregarFinal(222);
			lista.agregarFinal(333);
			lista.agregarFinal(444);
			lista.agregarFinal(555);
			lista.agregarFinal(566);
			lista.agregarFinal(777);
			
			
			int tamanio2 = lista.tamanio();
			for (int i=1; i<= tamanio2; i++)
				assertTrue(lista.eliminarEn(1));
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			
			lista.agregarFinal(22);
			lista.agregarFinal(33);
			lista.agregarFinal(44);
			lista.agregarFinal(55);
			lista.agregarFinal(66);
			lista.agregarFinal(77);
			
			assertFalse(lista.esVacia());
			
			
			while (!lista.esVacia()) {
				assertTrue(lista.eliminarEn(lista.tamanio()));
			}
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			
			lista.agregarFinal(22);
			lista.agregarFinal(33);
			lista.agregarFinal(44);
			lista.agregarFinal(55);
			lista.agregarFinal(66);
			lista.agregarFinal(77);
			
			assertFalse(lista.esVacia());
			
			
			while (!lista.esVacia()) {
				assertTrue(lista.eliminarEn(1));
			}
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			
			lista.agregarFinal(22);
			lista.agregarFinal(33);
			lista.agregarFinal(44);
			lista.agregarFinal(55);
			lista.agregarFinal(66);
			lista.agregarFinal(77);
			
			assertFalse(lista.esVacia());
			
			
			while (!lista.esVacia()) {
				assertTrue(lista.eliminarEn(lista.tamanio()));
			}
			
			assertTrue(lista.esVacia());
			
			assertEquals(0,lista.tamanio());
			
			
		}
		
		@Test
		public void testClonar() {
			lista.agregarFinal(222);
			lista.agregarFinal(333);
			lista.agregarFinal(444);
			lista.agregarFinal(555);
			lista.agregarFinal(566);
			lista.agregarFinal(777);
			
			lista.comenzar();
			lista.proximo();
			lista.proximo();
			
			ListaGenerica<Integer> clone = lista.clonar();
			assertEquals(new Integer(444), lista.proximo());
			assertEquals(new Integer(555), lista.proximo());
			assertEquals(new Integer(566), lista.proximo());
			assertEquals(new Integer(777), lista.proximo());
			
			assertEquals(6, clone.tamanio());
			clone.comenzar();
			clone.proximo();
			clone.proximo();
			assertEquals(new Integer(444), clone.proximo());
			assertEquals(new Integer(555), clone.proximo());
			assertEquals(new Integer(566), clone.proximo());
			assertEquals(new Integer(777), clone.proximo());
			
			
			
		}
		
		@Test
		public void testReemplazarEn() {
			lista.agregarFinal(222);
			lista.agregarFinal(333);
			lista.agregarFinal(444);
			lista.agregarFinal(555);
			lista.agregarFinal(566);
			lista.agregarFinal(777);
			
			lista.reemplazarEn(999, 1);
			assertEquals(new Integer(999), lista.elemento(1));
			
			lista.reemplazarEn(5, 5);
			
			assertEquals(new Integer(5), lista.elemento(5));
			
			lista.reemplazarEn(new Integer(999), new Integer(lista.tamanio()));
			
			assertEquals(new Integer(999), lista.elemento(lista.tamanio()));
		}
		
		@Test
		public void testEliminarActual() {
			lista.agregarFinal(2);
			lista.agregarFinal(3);
			lista.agregarFinal(4);
			lista.agregarFinal(5);
			lista.agregarFinal(6);
			lista.agregarFinal(7);
			
			lista.comenzar();
			lista.proximo();// el actual se posiciona en el numero 3
			
			lista.eliminarEn(2);// elimino el numero 3
			
			assertEquals(new Integer(4), lista.proximo()); // el proximo ahora es el numero 5
			
			lista.eliminar(5);
			assertEquals(new Integer(6), lista.proximo());
			
		}

}
