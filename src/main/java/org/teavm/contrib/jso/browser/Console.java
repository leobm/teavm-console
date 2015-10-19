package org.teavm.contrib.jso.browser;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * The console object provides access to the browser's debugging console. The
 * specifics of how it works vary from browser to browser, but there is a
 * factual set of features that are typically provided.
 */
public abstract class Console implements JSObject {

	private Console() {
	}

	@JSBody(params = {}, script = "return console;")
	public static native Console current();

	@JSBody(params = { "expression", "msg" }, script = "return this.assert(expression, msg)")
	public abstract void assertTrue(boolean expression, String msg);

	public abstract void clear();

	public abstract void count();

	public abstract void count(String label);

	@JSBody(params = { "objs" }, script = "return this.debug.apply(this, objs)")
	public abstract void debug(JSObject... objs);

	@JSBody(params = { "msg",
			"objs" }, script = "var args=[msg]; args.push.apply(args, objs);return this.debug.apply(this, args)")
	public abstract void debug(String msg, JSObject... objs);

	public abstract void dir(JSObject obj);

	public abstract void dirxml(JSObject obj);

	@JSBody(params = { "objs" }, script = "return this.error.apply(this, objs)")
	public abstract void error(JSObject... objs);

	@JSBody(params = { "objs" }, script = "return this.group.apply(this, objs)")
	public abstract void group(JSObject... objs);

	@JSBody(params = { "objs" }, script = "return this.groupCollapsed.apply(this, objs)")
	public abstract void groupCollapsed(JSObject... objs);

	public abstract void groupEnd();

	@JSBody(params = { "objs" }, script = "return this.info.apply(this, objs)")
	public abstract void info(JSObject... objs);

	@JSBody(params = { "msg",
			"objs" }, script = "var args=[msg]; args.push.apply(args, objs);return this.info.apply(this, args)")
	public abstract void info(String msg, JSObject... objs);

	@JSBody(params = { "msg",
			"objs" }, script = "var args=[msg]; args.push.apply(args, objs);return this.log.apply(this, args)")
	public abstract void log(String msg, JSObject... objs);

	@JSBody(params = { "objs" }, script = "return this.log.apply(this, objs)")
	public abstract void log(JSObject... objs);

	public abstract void profile();

	public abstract void profile(String label);

	public abstract void profileEnd();

	public abstract void time(String timerName);

	public abstract void timeEnd();

	public abstract void timeStamp();

	public abstract void timeStamp(String label);

	// currently not working in Firebug
	public abstract void trace();

	@JSBody(params = { "objs" }, script = "return this.warn.apply(this, objs)")
	public abstract void warn(JSObject... objs);

	@JSBody(params = { "msg",
			"objs" }, script = "var args=[msg]; args.push.apply(args, objs);return this.warn.apply(this, args)")
	public abstract void warn(String msg, JSObject... objs);

}
