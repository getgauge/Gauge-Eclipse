package com.thoughtworks.gauge.eclipse.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import com.thoughtworks.gauge.GaugeConnection;
import com.thoughtworks.gauge.PluginNotInstalledException;
import com.thoughtworks.gauge.eclipse.GaugePlugin;
import com.thoughtworks.gauge.eclipse.service.GaugeService;
import com.thoughtworks.gauge.eclipse.util.FileUtil;

public class GaugeClasspathContainerInitializer extends
		ClasspathContainerInitializer {

	private static final String JAR = "jar";
	private static final String JAVA = "java";
	private static HashMap<IJavaProject, IPath> libsCache = new HashMap<IJavaProject, IPath>();

	public GaugeClasspathContainerInitializer() {
	}

	public void initialize(IJavaProject project) throws CoreException {
		initialize(GaugeJavaClasspathContainer.GAUGE_JAVA_LIB_PATH, project);
	}

	public void initialize(IPath containerPath, IJavaProject project) throws CoreException {
		JavaCore.setClasspathContainer(containerPath, new IJavaProject[]{project}, new IClasspathContainer[]{createGaugeContainer(containerPath, project)}, null);
		project.save(null, true);
	}

	private IClasspathContainer createGaugeContainer(IPath containerPath, IJavaProject project) {
		return new GaugeJavaClasspathContainer(createClasspathEntries(project));
	}

	private IClasspathEntry[] createClasspathEntries(IJavaProject project) {
		IPath libsPath = getLibsPath(project);
		List<File> files = FileUtil.findFilesByExtension(libsPath.toFile(), JAR);
		ArrayList<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
		for (File file : files) {
			classpathEntries.add(JavaCore.newLibraryEntry(new Path(file.getAbsolutePath()), null, null));
		}
		return classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]);
	}

	private IPath getLibsPath(IJavaProject project) {
		if (libsCache.containsKey(project)) {
			return libsCache.get(project);
		}
		GaugeService service = GaugePlugin.getDefault().getGaugeWorkspace().getGaugeService(project.getProject());
		GaugeConnection connection = service.getGaugeConnection();
		String libPath = "";
		try {
			libPath = connection.getLibPath(JAVA);
		} catch (IOException e) {
			throw new RuntimeException(String.format("Could not find lib path: %s", e.getMessage()));
		} catch (PluginNotInstalledException e) {
			throw new RuntimeException("Gauge java plugin not installed.");
		}
		
		Path path = new Path(libPath);
		GaugeClasspathContainerInitializer.libsCache.put(project, path);
		return path;
	}
}
