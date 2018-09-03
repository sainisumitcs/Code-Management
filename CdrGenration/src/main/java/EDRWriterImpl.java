
public class EDRWriterImpl implements IEDRWriter {
	
	IFormatPolicy formatPolicy;
	IDestination destination;
	
	public EDRWriterImpl(IFormatPolicy formatPolicy, IDestination destination) {
		super();
		this.formatPolicy = formatPolicy;
		this.destination = destination;
	}

	
		
	/*public void writeCDR(ICDRInfo cdrInfo, IFormatPolicy ifc, IDestination dest) {	
		String cdr 			= cdrInfo.getCDRInfo(); // getCdrDetails,either json or csv
		String formatedCdr	= ifc.format(cdr);
		dest.write(formatedCdr);
	}
*/
	public void writeEDR(IEDRInfo cdrInfo) {
		// TODO Auto-generated method stub
		String cdr 			= cdrInfo.getEDRInfo(); // getCdrDetails,either json or csv	
		String formatedCdr	= formatPolicy.format(cdr);
		destination.write(formatedCdr);
		
	}

}
