package com.projetoPI.primefaces.compendio;

import java.util.List;

import javax.inject.Named;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.model.TreeDocument;
import com.projetoPI.service.CompendioStorageService;
import com.projetoPI.service.DBFileStorageService;

@Named
@Scope("view")
public class BuscaCompendioView {

	private TreeNode raiz;

	private List<Compendio> compendios;
	
	private TreeDocument selectedDocument;

	@Autowired
	private CompendioStorageService compendioStorageService;

	@Autowired
	private DBFileStorageService dbFileStorageService;

	public List<Compendio> getCompendios() {
		return compendioStorageService.getAllCompendio();
	}
	
	public void testa() {
		if(this.selectedDocument != null) {
		  System.out.println("testa " + selectedDocument.getNome());
		}
	}

	public TreeNode getRaiz() {
		TreeNode root = new CheckboxTreeNode(new TreeDocument("Compendios", "-", "Raiz"), null);
		List<Compendio> comps = compendioStorageService.getAllCompendio();
		List<DBFile> arqs = dbFileStorageService.getAllFile();

		for (Compendio compendio : comps) {
			TreeNode filho = new CheckboxTreeNode("Compêndio",new TreeDocument(compendio.getNome(), " - ", "Compêndio"), root);
			for (DBFile dbFile : arqs) {
				if (dbFile.getCompendio().getId() == compendio.getId()) {
					TreeNode neto = new CheckboxTreeNode("documento", new TreeDocument(dbFile.getFile_name(), " - ", dbFile.getFile_type(), dbFile), filho);
				}
			}
		}
		return root;
	}

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}

	public TreeDocument getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(TreeDocument selectedDocument) {
		this.selectedDocument = selectedDocument;
	}

}
