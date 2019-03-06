package netty.netty.rpc;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

import java.io.IOException;

public class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buf;

    @Override
    public int read() throws IOException {
        if (buf.isReadable()) {
            return buf.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        i1 = Math.min(available, i1);
        buf.readBytes(bytes, i, i1);
        return i1;
    }

    @Override
    public int available() throws IOException {
        return buf.readableBytes();
    }

    @Override
    public long skip(long l) throws IOException {
        int readable = buf.readableBytes();
        if (readable < l) {
            l = readable;
        }
        buf.readerIndex((int) (buf.readerIndex() + l));
        return l;
    }

    @Override
    public void close() throws IOException {

    }

    public ChannelBufferByteInput(ByteBuf buf) {
        this.buf = buf;
    }
}
