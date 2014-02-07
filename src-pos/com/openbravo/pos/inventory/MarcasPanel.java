//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2012 uniCenta
//    http://www.unicenta.net/unicentaopos
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.inventory;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

/**
 *
 * @author adrianromero
 */
public class MarcasPanel extends JPanelTable {
    
    private TableDefinition tmarcas;
    private MarcasEditor jeditor;
    
    /** Creates a new instance of JPanelCategories */
    public MarcasPanel() {        
    }   
    
    @Override
    protected void init() {   
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");           
        tmarcas = dlSales.getTableMarcas();
        jeditor = new MarcasEditor(app, dirty);    
    }
    
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tmarcas);
    }
    
    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tmarcas);      
    }
    
    @Override
    public Vectorer getVectorer() {
        return tmarcas.getVectorerBasic(new int[]{1});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tmarcas.getComparatorCreator(new int[]{1});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tmarcas.getRenderStringBasic(new int[]{1}));
    }
    
    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Marcas");
    } 
    
}
