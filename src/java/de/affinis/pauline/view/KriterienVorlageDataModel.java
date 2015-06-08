/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.hbm.PQKriterienVorlage;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Marin Cordeleanu
 */
public class KriterienVorlageDataModel extends ListDataModel<PQKriterienVorlage> implements SelectableDataModel<PQKriterienVorlage> {


        public KriterienVorlageDataModel() {
        }

        public KriterienVorlageDataModel(List<PQKriterienVorlage> data) {
            super(data);
        }

        @Override
        public PQKriterienVorlage getRowData(String rowKey) {
            //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  

            List<PQKriterienVorlage> cars = (List<PQKriterienVorlage>) getWrappedData();

            for (PQKriterienVorlage car : cars) {
                if (car.getName().equals(rowKey)) {
                    return car;
                }
            }

            return null;
        }

        @Override
        public Object getRowKey(PQKriterienVorlage car) {
            return car.getName();
        }
    }
