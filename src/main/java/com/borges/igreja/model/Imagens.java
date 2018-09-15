package com.borges.igreja.model;

import java.io.Serializable;


import javax.persistence.MappedSuperclass;

@MappedSuperclass //informar que a classe não deve ser persistida
public abstract class Imagens implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		

	    /*Se você utilizar o MySQL deve configurar
	    este campo como LongBlob, se for Postgresql
	    configure como text*/ 
		private String img;

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((img == null) ? 0 : img.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Imagens other = (Imagens) obj;
			if (img == null) {
				if (other.img != null)
					return false;
			} else if (!img.equals(other.img))
				return false;
			return true;
		}

}
